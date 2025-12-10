package factory;

import core.engine.Engine;
import core.engine.TurboHybridEngine;

public class EngineFactory {

    public Engine createEngineForTeam(String teamName) {
        switch (teamName.toLowerCase()) {
            case "red bull":
                return new TurboHybridEngine("RBPT 2023", 40, 90);
            case "mercedes":
                return new TurboHybridEngine("Mercedes PU 2023", 38, 92);
            case "ferrari":
                return new TurboHybridEngine("Ferrari 066/7", 37, 88);
            default:
                return new TurboHybridEngine("Generic PU", 30, 80);
        }
    }
}
