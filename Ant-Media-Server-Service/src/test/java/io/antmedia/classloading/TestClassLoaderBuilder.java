package io.antmedia.classloading;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.red5.classloading.ClassLoaderBuilder;

public class TestClassLoaderBuilder {
	
	//macosx-x86_64
	
	@Test
	public void testCudaNativeLoading() {
		
		
		File[] pluginFiles = new File[8];
		pluginFiles[0] = new File("ffmpeg-3.2.1-1.3-android-x86.jar");
		pluginFiles[1] = new File("ffmpeg-3.2.1-1.3-linux-x86.jar");
		pluginFiles[2] = new File("ffmpeg-3.2.1-1.3-linux-x86_64.jar");
		pluginFiles[3] = new File("ffmpeg-3.2.1-1.3-windows-x86.jar");
		pluginFiles[4] = new File("ffmpeg-3.2.1-1.3-windows-x86_64.jar");
		pluginFiles[5] = new File("ffmpeg-3.2.1-1.3-cuda-linux-x86_64.jar");
		pluginFiles[6] = new File("ffmpeg-3.2.1-1.3-macosx-x86_64.jar");
		pluginFiles[7] = new File("ffmpeg-3.2.1-1.3-macosx-x86.jar");
		
		
		List<URL> urlList = new ArrayList();
		
		ClassLoaderBuilder.loadPlugins(pluginFiles, urlList, true, "linux-x86_64");
		
		assertEquals(urlList.size(), 1);
		assertTrue(urlList.get(0).toString().contains("ffmpeg-3.2.1-1.3-cuda-linux-x86_64.jar"));
		
		
		urlList.clear();
		ClassLoaderBuilder.loadPlugins(pluginFiles, urlList, false, "linux-x86_64");
		assertEquals(urlList.size(), 1);
		assertTrue(urlList.get(0).toString().contains("ffmpeg-3.2.1-1.3-linux-x86_64.jar"));
		
		pluginFiles = new File[7];
		pluginFiles[0] = new File("ffmpeg-3.2.1-1.3-android-x86.jar");
		pluginFiles[1] = new File("ffmpeg-3.2.1-1.3-linux-x86.jar");
		pluginFiles[2] = new File("ffmpeg-3.2.1-1.3-linux-x86_64.jar");
		pluginFiles[3] = new File("ffmpeg-3.2.1-1.3-windows-x86.jar");
		pluginFiles[4] = new File("ffmpeg-3.2.1-1.3-windows-x86_64.jar");
	//pluginFiles[5] = new File("ffmpeg-3.2.1-1.3-cuda-linux-x86_64.jar");
		pluginFiles[6] = new File("ffmpeg-3.2.1-1.3-macosx-x86_64.jar");
		pluginFiles[5] = new File("ffmpeg-3.2.1-1.3-macosx-x86.jar");
		
		
		urlList.clear();
		ClassLoaderBuilder.loadPlugins(pluginFiles, urlList, true, "linux-x86_64");
		assertEquals(urlList.size(), 1);
		assertTrue(urlList.get(0).toString().contains("ffmpeg-3.2.1-1.3-linux-x86_64.jar"));
		
		
		urlList.clear();
		ClassLoaderBuilder.loadPlugins(pluginFiles, urlList, false, "linux-x86_64");
		assertEquals(urlList.size(), 1);
		assertTrue(urlList.get(0).toString().contains("ffmpeg-3.2.1-1.3-linux-x86_64.jar"));
		
		
		
		
		
		
		
		
	
	}

}
