package pl.javastart.restoffers.offer;

import org.springframework.stereotype.Service;
import pl.javastart.restoffers.category.Category;
import pl.javastart.restoffers.category.CategoryRepository;

import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    private final CategoryRepository categoryRepository;

    public OfferService(OfferRepository offerRepository, CategoryRepository categoryRepository) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
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

    public Optional<OfferDto> findById(Long id) {
        return offerRepository.findById(id).map(this::toDto);
    }

    public void save(OfferDto offerDto) {
        Offer offer = new Offer();
        Category category = categoryRepository.findByName(offerDto.getTitle());
        offer.setCategory(category);
        offerRepository.save(offer);
    }
}
