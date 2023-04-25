package pl.javastart.restoffers.offer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("api/offers")
@RestController
public class OfferRestController {

    private final OfferRepository offerRepository;

    private final OfferService offerService;

    public OfferRestController(OfferRepository offerRepository, OfferService offerService) {
        this.offerRepository = offerRepository;
        this.offerService = offerService;
    }

    @GetMapping("")
    public List<OfferDto> findAllOrByName(@RequestParam(required = false, name = "title") String title) {
        List<Offer> offersByName;
        if (title != null) {
            offersByName = offerRepository.findAllByTitleContainingIgnoreCase(title);
        } else {
            offersByName = offerRepository.findAll();
        }
        return offersByName
                .stream()
                .map(offerService::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/count")
    public long numberOfOffers() {
        return offerRepository.count();
    }

    @PostMapping("")
    public OfferDto addOffer(@RequestBody OfferDto offerDto) {
        offerService.save(offerDto);
        return offerDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> findById(@PathVariable Long id) {
        Optional<OfferDto> offer = offerService.findById(id);
        return offer
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        offerRepository.deleteById(id);
    }
}
