package hust.soict.globalict.aims.utils;

import java.util.Comparator;

import hust.soict.globalict.aims.model.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        int compareByTitle = MediaUtils.compareByTitle(o1, o2);
        if(compareByTitle == 0) {
            return -MediaUtils.compareByCost(o1, o2);
        }
        return compareByTitle;
    }
    
}
