package pl.javastart.restoffers.offer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/offers")
@RestController
public class OfferRestController {

    private final OfferRepository offerRepository;

    public OfferRestController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping("")
    public List<Offer> findAllOrByName(@RequestParam(required = false, name = "title") String title) {
        List<Offer> offersByName;
        if (title != null) {
            offersByName = offerRepository.findAllByTitle(title);
            return offersByName;
        } else {
            return offerRepository.findAll();
        }
    }

    @GetMapping("/count")
    public int numberOfOffers() {
        List<Offer> offers = offerRepository.findAll();
        return offers.size();
    }

    @PostMapping("")
    public Offer addOffer(@RequestBody Offer offer) {
        return offerRepository.save(offer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> findById(@PathVariable Long id) {
        Optional<Offer> offer = offerRepository.findById(id);
        return offer
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        offerRepository.deleteById(id);
    }
}
