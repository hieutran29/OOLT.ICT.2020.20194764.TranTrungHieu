package hust.soict.globalict.aims.utils;

import java.util.Comparator;

import hust.soict.globalict.aims.model.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        int compareByCost = MediaUtils.compareByCost(o1, o2);
        if(compareByCost == 0) {
            return MediaUtils.compareByTitle(o1, o2);
        }
        return -compareByCost;
    }
    
}
