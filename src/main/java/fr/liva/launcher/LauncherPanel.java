package fr.liva.launcher;

import fr.liva.GuiState;
import fr.liva.utils.LivaUtils;
import fr.liva.view.View;
import fr.liva.view.ViewChat;
import fr.liva.view.ViewMain;
import fr.liva.view.ViewOptions;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LauncherPanel extends JPanel {

    @Getter
    private Launcher launcher;

    public final Map<GuiState, View> views = new HashMap<>();

    // Images
    private Image background = LivaUtils.getResource("images/background.png");

    public LauncherPanel(Launcher launcher) {

        this.launcher = launcher;

        // Background
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        // Views
        ViewMain viewMain = new ViewMain(this);
        viewMain.init();
        viewMain.add();

        ViewOptions viewOptions = new ViewOptions(this);
        viewOptions.init();
        viewOptions.add();

        ViewChat viewChat = new ViewChat(this);
        viewChat.init();
        viewChat.add();

        views.put(GuiState.MAIN, viewMain);
        views.put(GuiState.OPTIONS, viewOptions);
        views.put(GuiState.CHAT, viewChat);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        LivaUtils.drawFullsizedImage(g, this, background);

        repaint();
    }

    public void setState(GuiState guiState) {
        views.forEach((state, view) -> {
            if (state == guiState) {
                view.show();
            } else if (guiState.getSubStates().contains(state)) {
                view.show();
            } else {
                view.hide();
            }
        });
    }
}
