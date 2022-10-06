package fr.liva;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum GuiState {

    CONNECT(null),
    CHAT(null),
    MAIN(CONNECT),
    OPTIONS(CHAT);

    private final GuiState subState;

    public List<GuiState> getSubStates() {
        List<GuiState> guiStates = new ArrayList<>();

        if (getSubState() == null) {
            return guiStates;
        } else {
            guiStates.add(getSubState());
        }

        guiStates.addAll(getSubState().getSubStates());

        return guiStates;
    }
}
