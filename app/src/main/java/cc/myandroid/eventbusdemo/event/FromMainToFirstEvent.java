package cc.myandroid.eventbusdemo.event;

/**
 * Created by chenzd on 2016/12/23.
 */

public class FromMainToFirstEvent {
    public String getStr(){
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public FromMainToFirstEvent(String str) {

        this.str = str;
    }

    String str;
    public FromMainToFirstEvent() {

    }
}
