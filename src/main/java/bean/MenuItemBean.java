package bean;

/**
 * This class represents a MenuItemBean
 * <p>
 * Created by Skyler Layne © 2016
 */
public class MenuItemBean {

    private int id;
    private int ref;
    private String lcd1; // The top level of the display

    private String lcd2; // The bottom level of the display

    private byte mode; // What the mode of the menu item

    private byte back; // Ref # of parent


    private byte left; // Ref # of left sibling
    private byte right; // Ref # of the right sibling
    private byte select; // Action upon commit.
    private byte usr1; // default 0
    private byte usr2; // default 0
    private byte enable; // Encrypted or not.

    /**
     * Construct a new MenuItemBean.
     *
     * @param lcd1
     * @param lcd2
     * @param mode
     * @param back
     * @param left
     * @param select
     * @param right
     * @param enable
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
}
