/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpl;

public class ParkingSlot {
    private int slotNumber;
    private boolean isOccupied;

    public ParkingSlot() {}

    public ParkingSlot(int slotNumber, boolean isOccupied) {
        this.slotNumber = slotNumber;
        this.isOccupied = isOccupied;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}

