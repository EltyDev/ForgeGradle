package net.minecraftforge.gradle.common.version;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class VersionJson implements Serializable {


        public AssetIndex assetIndex;
        public String assets;
        public Map<String, Download> downloads;
        public String id;
        public List<Download> libraries;
        public String mainClass;
        public String minecraftArguments;
        public int minimumLauncherVersion;
        public String releaseTime;
        public String time;
        public String release;

        public static class AssetIndex implements Serializable
        {
            public String id;
            public String sha1;
            public long size;
            public long totalSize;
            public String url;
        }

        public static class Download implements Serializable
        {
            public String path;
            public String sha1;
            public long size;
            public String url;
        }
}
