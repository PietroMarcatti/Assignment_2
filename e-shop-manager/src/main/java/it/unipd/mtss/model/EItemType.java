////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public enum EItemType {
    MOTHERBOARD("MB"), PROCESSOR("CPU"), MOUSE("MS"), KEYBOARD("KB");


    private final String textValue;

    EItemType(final String textValue) {
       this.textValue = textValue;
    }

    public String toString() {
        return textValue;
    }
}