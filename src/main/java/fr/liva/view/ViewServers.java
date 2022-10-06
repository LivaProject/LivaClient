package fr.liva.view;

import fr.liva.GuiState;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.others.LivaBackwardButton;
import fr.liva.components.others.LivaText;
import fr.liva.components.others.LivaTitleText;
import fr.liva.launcher.LauncherPanel;
import fr.liva.utils.LivaUtils;
import fr.liva.utils.servers.Server;
import fr.liva.utils.servers.ServersList;

import java.util.Map;

public class ViewServers extends View {

    // Texts
    private LivaTitleText mainText = new LivaTitleText();
    private LivaText backwardText = new LivaText();

    // Buttons
    private LivaButton backwardButton = new LivaBackwardButton();

    public ViewServers(LauncherPanel panel) {
        super(panel, ViewType.MAIN);
    }

    @Override
    public void init() {

        // Texts
        backwardText.setText("Retour");
        backwardText.setBounds(100, 610, 550, 90);

        mainText.setText("Serveurs");

        int i = 0;
        for (Map.Entry<String, Server> serverEntry : ServersList.servers.entrySet()) {
            Server server = serverEntry.getValue();

            LivaText text = new LivaText();
            text.setText(serverEntry.getKey());
            text.setBounds(100, 300 + (i * 100), 550, 90);

            LivaButton button = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));
            button.setBounds(100, 300 + (i * 100), 550, 90);
            button.setAction(LivaActionType.PRESS, () -> {
                ViewConnect viewConnect = (ViewConnect) getPanel().getView(ViewConnect.class);
                viewConnect.getAddressField().setText(server.getAddress());
                viewConnect.getPortField().setText(String.valueOf(server.getPort()));
            });

            addComponent(text, button);
            i++;
        }


        // Buttons
        backwardButton.setAction(LivaActionType.PRESS, () -> {
            getPanel().setState(GuiState.MAIN);
        });


        // Add Elements
        addComponent(mainText, backwardText, backwardButton);
    }
}
