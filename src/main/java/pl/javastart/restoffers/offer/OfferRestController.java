package pl.javastart.restoffers.offer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/offers")
@RestController
public class OfferRestController {

    private final OfferRepository offerRepository;

    public OfferRestController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping("/")
    public List<Offer> findAll() {
        offerRepository.findAll();
        return offerRepository.findAll();
    }

    @GetMapping("/count")
    public int numberOfOffers() {
        List<Offer> offers = offerRepository.findAll();
        return offers.size();
    }

    @GetMapping("/?title=param_value")
    public List<Offer> offerByName(@RequestParam String title) {
        List<Offer> offers = offerRepository.findAll();
        List<Offer> offersByName = new ArrayList<>();
        for (Offer offer : offers) {
            if (offer.getTitle().equals(title)) {
                offersByName.add(offer);
                return offersByName;
            }
        }
        return offers;
    }

}
