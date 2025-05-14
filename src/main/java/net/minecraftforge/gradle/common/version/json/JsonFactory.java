package net.minecraftforge.gradle.common.version.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import net.minecraftforge.gradle.common.version.AssetIndex;
import net.minecraftforge.gradle.common.version.Version;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import net.minecraftforge.gradle.common.version.VersionJson;
import net.minecraftforge.gradle.common.version.VersionManifest;

public class JsonFactory
{
    public static final Gson GSON;
    static
    {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(new EnumAdaptorFactory());
        builder.registerTypeAdapter(Date.class, new DateAdapter());
        builder.registerTypeAdapter(File.class, new FileAdapter());
        builder.enableComplexMapKeySerialization();
        builder.setPrettyPrinting();
        GSON = builder.create();
    }

    public static Version loadVersion(File json) throws JsonSyntaxException, JsonIOException, IOException
    {
        FileReader reader = new FileReader(json);
        Version v =  GSON.fromJson(reader, Version.class);
        reader.close();
        return v;
    }
    
    public static AssetIndex loadAssetsIndex(File json) throws JsonSyntaxException, JsonIOException, IOException
    {
        FileReader reader = new FileReader(json);
        AssetIndex a =  GSON.fromJson(reader, AssetIndex.class);
        reader.close();
        return a;
    }

    public static VersionJson loadVersionJson(File json) throws JsonSyntaxException, JsonIOException, IOException
    {
        FileReader reader = new FileReader(json);
        VersionJson v =  GSON.fromJson(reader, VersionJson.class);
        reader.close();
        return v;
    }

    public static VersionManifest loadVersionManifest(File json) throws JsonSyntaxException, JsonIOException, IOException
    {
        FileReader reader = new FileReader(json);
        VersionManifest v =  GSON.fromJson(reader, VersionManifest.class);
        reader.close();
        return v;
    }
}
