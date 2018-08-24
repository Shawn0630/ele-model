package com.ele.model.mysql;

import com.ele.model.DataModel;
import com.ele.model.EleImmutable;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("javadoc")
@EleImmutable
public interface Shop extends DataModel {
    default UUID id() {
        return UUID.randomUUID();
    }
    String shopName();
    String shopAddress();
    String shopURL();
    String shopService();
    String shopAnnouncement();
    String shopSlogan();
    float shopDeliveryFee();
    float shopSendThreshold();
    Date shopRegistration();
    float shopLat();
    float shopLng();
    boolean isBird();
    boolean isInsurance();
    boolean isBrand();
    boolean needTip();
    int activityNum();
    String promotion();

}
