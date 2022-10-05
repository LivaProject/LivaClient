package fr.liva.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public abstract class VueMenu {

    private JPanel panel;
    private List<Component> components;

    public VueMenu(JPanel panel) {
        this.panel = panel;
        this.components = new ArrayList<>();
    }

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
