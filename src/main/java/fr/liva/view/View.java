package fr.liva.view;

import fr.liva.launcher.LauncherPanel;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public abstract class View {

    private LauncherPanel panel;
    private List<Component> components;

    public View(LauncherPanel panel) {
        this.panel = panel;
        this.components = new ArrayList<>();
    }

    public abstract void init();

    public void addComponent(Component... components) {
        this.components.addAll(Arrays.asList(components));
    }

    public void removeComponent(Component... components) {
        this.components.removeAll(Arrays.asList(components));
    }

    public void add() {
        this.components.forEach(panel::add);
    }

    public void remove() {
        this.components.forEach(panel::remove);
    }

    public void show() {
        this.components.forEach(component -> component.setVisible(true));
    }

    public void hide() {
        this.components.forEach(component -> component.setVisible(false));
    }

}
