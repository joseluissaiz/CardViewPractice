package com.overshade.cardviewpractice;

/**___Game Info >>> used for display in a list <<< ___*/
public class GameInfo {

    //================================================================================
    // Properties
    //================================================================================

    private String mName;
    private int mPreviewResource;

    //================================================================================
    // Constructors
    //================================================================================

    public GameInfo(String name, int previewResource) {
        this.mName = name;
        this.mPreviewResource = previewResource;
    }

    //================================================================================
    // Accessors
    //================================================================================

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getPreviewResource() {
        return mPreviewResource;
    }

    public void setPreviewResource(int mPreviewResource) {
        this.mPreviewResource = mPreviewResource;
    }
}
