package dev.ihm;

import dev.exception.PlatException;
import dev.ihm.options.IOptionMenu;
import dev.ihm.options.OptionAjouterPlat;
import dev.ihm.options.OptionListerPlats;
import dev.ihm.options.OptionTerminer;
import dev.service.IPlatService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    /** actions */
    private Map<Integer, IOptionMenu> actions = new HashMap<>();

    /** menu */
    private String menu;
    
    /** scanner */
    private Scanner scanner;

    /** Constructor
     * @param scanner
     * @param service
     */
    public Menu(Scanner scanner, IPlatService service) {
        actions.put(1, new OptionListerPlats(service));
        actions.put(2, new OptionAjouterPlat(scanner, service));
        actions.put(99, new OptionTerminer());
        this.scanner = scanner;
    }

    /**
     * Affichage du menu
     * 
     */
    public void afficher() {
        boolean continuer = true;

        while (continuer) {
            System.out.println(getMenuTexte());
            int choix = this.scanner.nextInt();

            try {
                this.actions.get(choix).executer();
            } catch (PlatException e) {
                continuer = false;
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Texte du menu
     * 
     * @return
     */
    private String getMenuTexte() {
        if (menu == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("** Restaurant Console App **");
            sb.append("\n");
            this.actions.forEach((index, option) -> {
                sb.append(index);
                sb.append(". ");
                sb.append(option.getTitre());
                sb.append("\n");
            });
            this.menu = sb.toString();
        }
        return this.menu;
    }
}
