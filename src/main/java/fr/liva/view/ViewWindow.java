package fr.liva.view;

import fr.liva.GuiState;
import fr.liva.ViewType;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.others.LivaBackwardButton;
import fr.liva.components.others.LivaText;
import fr.liva.components.others.LivaTitleText;
import fr.liva.components.window.LivaWindow;
import fr.liva.launcher.LauncherPanel;
import lombok.Getter;

import java.awt.*;

public class ViewWindow extends View {

    // Window
    private LivaWindow window = new LivaWindow();

    // Texts
    @Getter
    private LivaTitleText titleText = new LivaTitleText();

    @Getter
    private LivaText mainText = new LivaText(32);

    private LivaText closeText = new LivaText();

    // Buttons
    private LivaButton closeButton = new LivaBackwardButton();

    public ViewWindow(LauncherPanel panel) {
        super(panel, ViewType.WINDOW);
    }

    @Override
    public void init() {

        // Texts
        titleText.setText("Window");
        titleText.setBounds(250, 200, 580, 100);
        mainText.setBounds(250, 300, 580, 180);

        closeText.setText("Fermer");
        closeText.setBounds(300, 470, 480, 80);

        // Buttons
        closeButton.setBounds(300, 470, 480, 80);
        closeButton.setAction(LivaActionType.PRESS, () -> {
            getPanel().setState(GuiState.MAIN);
        });

        // Add Components
        addComponent(titleText, mainText, closeText, closeButton, window);
    }

    @Override
    public void hide() {
        super.hide();

        getPanel().remove(window);
    }

    @Override
    public void show() {
        super.show();

        getPanel().add(window);
    }
}
