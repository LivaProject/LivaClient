package fr.liva.components.others;

import fr.liva.components.buttons.LivaButton;
import fr.liva.utils.LivaUtils;

public class LivaBackwardButton extends LivaButton {

    public LivaBackwardButton() {
        super(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));

        setBounds(100, 610, 550, 90);
    }
}
