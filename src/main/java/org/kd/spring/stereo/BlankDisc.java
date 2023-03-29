package org.kd.spring.stereo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BlankDisc implements CompactDisc{

    private String title;
    private String artist;

    @Override
    public void play() {
        System.out.println("Odtawrzam utwor " + title);
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public String getArtist() {
        return "";
    }
}
