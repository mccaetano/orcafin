package org.marcelocc.orcafina;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

@Controller
public class WebController {

    public String index(Model model, HttpSession session) {        
        List<String> favoriteColors = getFavColors(session);
        model.addAttribute("favoriteColors", favoriteColors);
        model.addAttribute("sessionId", session.getId());
        return "index";
    }
    private List<String> getFavColors(HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> favoriteColors = (List<String>) session
          .getAttribute("favoriteColors");
        
        if (favoriteColors == null) {
            favoriteColors = new ArrayList<>();
        }
        return favoriteColors;
    }
}
