package net.minecraftforge.gradle.common.version;

import java.io.Serializable;
import java.util.List;

public class VersionManifest implements Serializable
{

    public Latest latest;
    public List<Version> versions;

    public static class Latest implements Serializable
    {
        String release;
        String snapshot;
    }

    public static class Version implements Serializable
    {
        public String id;
        public String type;
        public String url;
        public String time;
        public String releaseTime;
        public String sha1;
        public int complianceLevel;
    }



}
