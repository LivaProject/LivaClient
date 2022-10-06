package fr.liva.view;

import fr.liva.ViewType;
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

    private ViewType viewType;

    public View(LauncherPanel panel, ViewType viewType) {
        this.panel = panel;
        this.components = new ArrayList<>();
        this.viewType = viewType;
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
