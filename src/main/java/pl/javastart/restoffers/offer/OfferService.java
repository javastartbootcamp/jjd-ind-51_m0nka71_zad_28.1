package pl.javastart.restoffers.offer;

import org.springframework.stereotype.Service;
import pl.javastart.restoffers.category.Category;
import pl.javastart.restoffers.category.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    private final CategoryRepository categoryRepository;

    public OfferService(OfferRepository offerRepository, CategoryRepository categoryRepository) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
    }

    public Optional<OfferDto> findById(Long id) {
        return offerRepository.findById(id).map(this::toDto);
    }

    public List<OfferDto> findAllOrByTitle(String title) {
        List<Offer> offersByName;
        if (title != null) {
            offersByName = offerRepository.findAllByTitleContainingIgnoreCase(title);
        } else {
            offersByName = offerRepository.findAll();
        }
        return offersByName
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public OfferDto toDto(Offer offer) {
        OfferDto offerDto = new OfferDto();
        offerDto.setId(offer.getId());
        offerDto.setTitle(offer.getTitle());
        offerDto.setDescription(offer.getDescription());
        offerDto.setImgUrl(offer.getImgUrl());
        offerDto.setPrice(offer.getPrice());
        offerDto.setCategory(offer.getCategory().getName());
        return offerDto;
    }

    private Offer toOffer(OfferDto offerDto) {
        Offer offer = new Offer();
        offer.setId(offerDto.getId());
        offer.setTitle(offerDto.getTitle());
        offer.setDescription(offerDto.getDescription());
        offer.setImgUrl(offerDto.getImgUrl());
        offer.setPrice(offerDto.getPrice());
        Category category = categoryRepository.findByName(offerDto.getCategory()).orElseThrow();
        offer.setCategory(category);
        return offer;
    }

    public OfferDto save(OfferDto offerDto) {
        Offer offer = toOffer(offerDto);
        Offer savedEntity = offerRepository.save(offer);
        return toDto(savedEntity);
    }

    public void deleteById(Long id) {
        offerRepository.deleteById(id);
    }

    public long countOffers() {
        return offerRepository.count();
    }
}
