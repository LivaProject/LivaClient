package fr.liva.launcher;

import fr.liva.GuiState;
import fr.liva.utils.LivaUtils;
import fr.liva.view.*;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LauncherPanel extends JPanel {

    @Getter
    private Launcher launcher;

    @Getter
    private final Map<GuiState, View> views = new HashMap<>();

    private final Image background = LivaUtils.getResource("images/background.png");

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

        ViewConnect viewConnect = new ViewConnect(this);
        viewConnect.init();
        viewConnect.add();

        ViewRegister viewRegister = new ViewRegister(this);
        viewRegister.init();
        viewRegister.add();

        ViewWindow viewWindow = new ViewWindow(this);
        viewWindow.init();
        viewWindow.add();

        views.put(GuiState.MAIN, viewMain);
        views.put(GuiState.OPTIONS, viewOptions);
        views.put(GuiState.CHAT, viewChat);
        views.put(GuiState.CONNECT, viewConnect);
        views.put(GuiState.REGISTER, viewRegister);
        views.put(GuiState.WINDOW, viewWindow);

        setState(GuiState.MAIN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        LivaUtils.drawFullsizedImage(g, this, background);

        repaint();
    }

    public View getView(Class<? extends View> v) {
        for (Map.Entry<GuiState, View> viewEntry : views.entrySet()) {
            if (viewEntry.getValue().getClass() == v) {
                return viewEntry.getValue();
            }
        }
        return null;
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
