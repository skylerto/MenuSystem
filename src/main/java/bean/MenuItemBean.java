package bean;

import export.Csvable;

/**
 * This class is a data model for what a menu item is transformed into.
 * <p>
 * Created by Skyler Layne © 2016
 */
public class MenuItemBean implements Csvable {

    private int id;
    private int ref;
    private String lcd1;
    private String lcd2;
    private byte mode;
    private byte back;
    private byte left;
    private byte right;
    private byte select;
    private byte usr1; // default 0
    private byte usr2; // default 0
    private byte enable;

    /**
     * Construct a new MenuItemBean.
     *
     * @param lcd1 the first line to be displayed.
     * @param lcd2 the second line to be displayed.
     * @param mode the mode for the menu item to run in.
     * @param back the ref of the menu item to go back to.
     * @param left the ref of the menu item to go left to.
     * @param select the action to occur when the select is clicked (down a menu item/ execute code).
     * @param right the ref of the menu item to go right to.
     * @param enable is this menu item encrypted of not.
     */
    public MenuItemBean(String lcd1, String lcd2, byte mode, byte back, byte left, byte select, byte right, byte enable) {
        this.lcd1 = lcd1;
        this.lcd2 = lcd2;
        this.mode = mode;
        this.back = back;
        this.left = left;
        this.select = select;
        this.right = right;
        this.enable = enable;
        this.usr1 = 0;
        this.usr2 = 0;
    }


    /**
     * Return the reference number of the current MenuItemBean.
     *
     * @return reference number.
     */
    public int getRef() {
        return ref;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getLcd1() {
        return lcd1;
    }

    public void setLcd1(String lcd1) {
        this.lcd1 = lcd1;
    }

    public String getLcd2() {
        return lcd2;
    }

    public void setLcd2(String lcd2) {
        this.lcd2 = lcd2;
    }

    public byte getMode() {
        return mode;
    }

    public void setMode(byte mode) {
        this.mode = mode;
    }

    public byte getBack() {
        return back;
    }

    public void setBack(byte back) {
        this.back = back;
    }

    public byte getLeft() {
        return left;
    }

    public void setLeft(byte left) {
        this.left = left;
    }

    public byte getRight() {
        return right;
    }

    public void setRight(byte right) {
        this.right = right;
    }

    public byte getSelect() {
        return select;
    }

    public void setSelect(byte select) {
        this.select = select;
    }

    public byte getUsr1() {
        return usr1;
    }

    public void setUsr1(byte usr1) {
        this.usr1 = usr1;
    }

    public byte getUsr2() {
        return usr2;
    }

    public void setUsr2(byte usr2) {
        this.usr2 = usr2;
    }

    public byte getEnable() {
        return enable;
    }

    public void setEnable(byte enable) {
        this.enable = enable;
    }

    /**
     * Return a CSV of the current record.
     *
     * @return the CSV as a string
     */
    public String getCsv() {
        StringBuilder csv = new StringBuilder();
        csv.append(this.lcd1);
        csv.append(",");
        csv.append(this.lcd2);
        csv.append(",");
        csv.append(this.mode);
        csv.append(",");
        csv.append(this.back);
        csv.append(",");
        csv.append(this.left);
        csv.append(",");
        csv.append(this.select);
        csv.append(",");
        csv.append(this.right);
        csv.append(",");
        csv.append(this.usr1);
        csv.append(",");
        csv.append(this.usr2);
        csv.append(",");
        csv.append(this.enable);

        return csv.toString();
    }
}
