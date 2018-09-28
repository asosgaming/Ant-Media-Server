/*
 *  Copyright 2013 The WebRTC project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree. An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */

package org.webrtc;

/**
 * Java wrapper for a C++ AudioSourceInterface.  Used as the source for one or
 * more {@code AudioTrack} objects.
 */
public class AudioSource extends MediaSource {
	/**
	 * Native Peer Connection Factory
	 */
	private long nativeFactory;

	public AudioSource(long nativeSource, long nativeFactory) {
		super(nativeSource);
		this.nativeFactory = nativeFactory;
	}


	public void writeAudioFrame(byte[] data, int length) {
		nativeWriteAudioFrame(nativeFactory, data, length);
	}
	
	public void writeMockFrame(int length) {
		  nativeWriteMockAudioFrame(nativeFactory, length);
	 }
	
	/**
	 * Write 48K Hz stereo data
	 * @param data
	 * @param length
	 */
	private native void nativeWriteAudioFrame(long nativeFactory, byte[] data, int length);
	
	private native void nativeWriteMockAudioFrame(long nativeFactory, int length);
}
