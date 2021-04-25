package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkyController {
  private final List<Vizitka> vizitky;

  private VizitkyController() {
    vizitky = Arrays.asList(
            new Vizitka("Dita (Přikrylová) Formánková", "Czechitas z. s.","dita@czechitas.cs", "420 800123456", "www.czechitas.cz", "11000 Praha 1", "Václavské náměstí 837/11"),
            new Vizitka("Barbora Bühnová", "Czechitas z. s.", null,"+420 800123456", "www.czechitas.cz", "11000 Praha 1", "Václavské náměstí 837/11"),
            new Vizitka("Monika Ptáčníková","Czechitas z. s.", "monika@czechitas.cs", "+420 800123456", "www.czechitas.cz", "11000 Praha 1","Václavské náměstí 837/11"),
            new Vizitka("Mirka Zatloukalová", "Czechitas z. s.", "mirka@czechitas.cs", null, "www.czechitas.cz", "11000 Praha 1", "Václavské náměstí 837/11")
    );
  }


  @GetMapping("/")
  public ModelAndView seznam() {
    ModelAndView modelAndView = new ModelAndView("seznam");
    modelAndView.addObject("seznam", vizitky);
    return modelAndView;
  }

  @GetMapping("/detail")
  public ModelAndView detail(int id) {
    ModelAndView modelAndView = new ModelAndView("detail");
    modelAndView.addObject("vizitka", vizitky.get(id));
    return modelAndView;
  }
}
