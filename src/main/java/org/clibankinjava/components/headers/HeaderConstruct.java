package org.clibankinjava.components.headers;

public final class HeaderConstruct implements HeaderBuilder {

    private final Header header;

    public HeaderConstruct() {
        this.header = new Header();
    }

    @Override
    public HeaderConstruct setupHeaderMessage(String headerMessage, boolean isForMenu) throws InterruptedException {
        this.header.setHeaderMessage(headerMessage, isForMenu);
        return this;
    }

    @Override
    public HeaderConstruct setupSubHeaderMessage(String subHeaderMessage, boolean isforMenu) throws InterruptedException {
        this.header.setSubHeaderMessage(subHeaderMessage, isforMenu);
        return this;
    }

    @Override
    public HeaderConstruct setupEmptySpacesFromLeftEdgeScreen(int emptySpacesFromLeftEdgeScreen) {
        this.header.setEmptySpacesFromLeftEdgeScreen(emptySpacesFromLeftEdgeScreen);
        return this;
    }

    @Override
    public HeaderConstruct setupEmptySpacesFromTopEdgeScreen(int emptySpacesFromTopEdgeScreen) {
        this.header.setEmptySpacesFromTopEdgeScreen(emptySpacesFromTopEdgeScreen);
        return this;
    }

    @Override
    public HeaderConstruct setupEmptySpacesBelowTheHeader(int emptySpacesBelowTheHeader) {
        this.header.setEmptySpacesBelow(emptySpacesBelowTheHeader);
        return this;
    }

    @Override
    public HeaderConstruct setupLengthOfBorders() {
        this.header.setLengthOfBorders();
        return this;
    }

    @Override
    public Header build() {
        return header;
    }
}
