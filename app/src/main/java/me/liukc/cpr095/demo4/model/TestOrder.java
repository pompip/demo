package me.liukc.cpr095.demo4.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by CPR095 on 2015/7/30.
 */
public class TestOrder implements Parcelable{

    public String orderType = "实时";
    public String startPosition = "龙阳大道67号";
    public String endPosition = "武汉火车站";

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(orderType);
        parcel.writeString(startPosition);
        parcel.writeString(endPosition);

    }

    public final static Parcelable.Creator<TestOrder> CREATOR = new Creator<TestOrder>() {
        @Override
        public TestOrder createFromParcel(Parcel parcel) {
            TestOrder order = new TestOrder();
            order.orderType = parcel.readString();
            order.startPosition = parcel.readString();
            order.endPosition = parcel.readString();
            return order;
        }

        @Override
        public TestOrder[] newArray(int i) {
            return new TestOrder[0];
        }
    };

    public TestOrder() {
    }
    public TestOrder(Parcel parcel) {
        orderType = parcel.readString();
        startPosition = parcel.readString();
        endPosition = parcel.readString();
    }

}
