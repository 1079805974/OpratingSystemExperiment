package experiment3;

public class PageTable {
    private PageTableElement[] pageTableElements = {
            new PageTableElement(0, 1, 5, 11),
            new PageTableElement(1, 1, 8, 12),
            new PageTableElement(3, 1, 1, 21),
            new PageTableElement(4, 0, 0, 22),
            new PageTableElement(5, 0, 0, 23),
            new PageTableElement(6, 0, 0, 121)
    };

    public int fetchAddress(int pageNumber, int unitNumber) {
        return pageTableElements[pageNumber].getAddress(unitNumber);
    }

    public boolean hasFatal(int pageNumber) {
        return !pageTableElements[pageNumber].isValid();
    }
}

class PageTableElement {
    public static final int BLOCK_LENGTH = 4;

    private int pageNumber;
    private boolean valid;
    private int blockNumber;
    private int diskIndex;

    public PageTableElement(int pageNumber, boolean valid, int blockNumber, int diskIndex) {
        this.pageNumber = pageNumber;
        this.valid = valid;
        this.blockNumber = blockNumber;
        this.diskIndex = diskIndex;
    }

    public PageTableElement(int pageNumber, int valid, int blockNumber, int diskIndex) {
        this.pageNumber = pageNumber;
        this.valid = valid == 0 ? false : true;
        this.blockNumber = blockNumber;
        this.diskIndex = diskIndex;
    }

    public int getAddress(int unitNumber) {
        return Integer.valueOf(blockNumber + "" + unitNumber);
    }

    public boolean isValid() {
        return valid;
    }
}