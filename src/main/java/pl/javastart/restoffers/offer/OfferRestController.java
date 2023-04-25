package pl.javastart.restoffers.offer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/offers")
@RestController
public class OfferRestController {

    private final OfferService offerService;

    public OfferRestController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("")
    public List<OfferDto> findAllOrByName(@RequestParam(required = false, name = "title") String title) {
        return offerService.findAllOrByTitle(title);
    }

    @GetMapping("/count")
    public long numberOfOffers() {
        return offerService.countOffers();
    }

    @PostMapping("")
    public OfferDto addOffer(@RequestBody OfferDto offerDto) {
        return offerService.save(offerDto);
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
        offerService.deleteById(id);
    }
}
