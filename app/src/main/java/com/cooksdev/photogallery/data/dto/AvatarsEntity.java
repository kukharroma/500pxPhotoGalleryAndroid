package com.cooksdev.photogallery.data.dto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvatarsEntity {

    @SerializedName("default")
    @Expose
    private DefaultEntity _default;
    @SerializedName("large")
    @Expose
    private LargeEntity large;
    @SerializedName("small")
    @Expose
    private SmallEntity small;
    @SerializedName("tiny")
    @Expose
    private TinyEntity tiny;

    /**
     * 
     * @return
     *     The _default
     */
    public DefaultEntity getDefault() {
        return _default;
    }

    /**
     * 
     * @param _default
     *     The default
     */
    public void setDefault(DefaultEntity _default) {
        this._default = _default;
    }

    /**
     * 
     * @return
     *     The large
     */
    public LargeEntity getLarge() {
        return large;
    }

    /**
     * 
     * @param large
     *     The large
     */
    public void setLarge(LargeEntity large) {
        this.large = large;
    }

    /**
     * 
     * @return
     *     The small
     */
    public SmallEntity getSmall() {
        return small;
    }

    /**
     * 
     * @param small
     *     The small
     */
    public void setSmall(SmallEntity small) {
        this.small = small;
    }

    /**
     * 
     * @return
     *     The tiny
     */
    public TinyEntity getTiny() {
        return tiny;
    }

    /**
     * 
     * @param tiny
     *     The tiny
     */
    public void setTiny(TinyEntity tiny) {
        this.tiny = tiny;
    }

}
