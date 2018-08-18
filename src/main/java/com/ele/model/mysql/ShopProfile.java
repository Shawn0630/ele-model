package com.ele.model.mysql;

import com.ele.model.DataModel;
import com.ele.model.EleImmutable;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("javadoc")
@EleImmutable
public interface ShopProfile extends DataModel {
    default UUID id() {
        return UUID.randomUUID();
    }
    String ImgUrl();

    boolean isBrand();

    String shopName();

    double starNum();

    int monthlySales();

    double initMoney();

    double deliveryFee();

    double distance();

    String needTime();

    boolean isBird();

    boolean isOntime();

    boolean isInsurance();

    boolean needtip();

    boolean isNewShop();

}
