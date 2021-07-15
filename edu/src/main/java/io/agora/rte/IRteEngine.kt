package io.agora.rte

import android.content.Context
import androidx.annotation.NonNull
import io.agora.rtc.RtcEngine
import io.agora.rtc.video.VideoCanvas
import io.agora.rtc.video.VideoEncoderConfiguration
import io.agora.rte.data.RteAudioReverbPreset
import io.agora.rte.data.RteAudioVoiceChanger
import io.agora.rte.listener.RteStatisticsReportListener

interface IRteEngine {
    fun init(context: Context, appId: String, logFileDir: String)

    fun setRtcParameters(parameters: String): Int

    fun loginRtm(rtmUid: String, rtmToken: String, @NonNull callback: RteCallback<Unit>)

    fun logoutRtm()

    /**作用于rteChannel*/
    fun createChannel(channelId: String, eventListener: io.agora.rte.listener.RteChannelEventListener): IRteChannel

    fun getRtcCallId(id: String): String

    fun getRtmSessionId(): String

    /**作用于全局*/
    fun enableLocalMedia(audio: Boolean, video: Boolean): Int

    /**作用于rtcChannel*/
    fun setClientRole(channelId: String, role: Int): Int

    fun setClientRole(role: Int): Int

    /**作用于rtcChannel*/
    fun publish(channelId: String): Int

    /**作用于rtcChannel*/
    fun unpublish(channelId: String): Int

    /**作用于全局*/
    fun updateLocalStream(hasAudio: Boolean, hasVideo: Boolean): Int

    fun updateLocalAudioStream(hasAudio: Boolean): Int

    fun updateLocalVideoStream(hasVideo: Boolean): Int

    /**作用于rtcChannel*/
    fun muteRemoteStream(channelId: String, uid: Int, muteAudio: Boolean, muteVideo: Boolean): Int

    /**作用于全局*/
    fun muteLocalStream(muteAudio: Boolean, muteVideo: Boolean): Int

    fun muteLocalAudioStream(muteAudio: Boolean):Int

    fun muteLocalVideoStream(muteVideo: Boolean):Int

    fun setLocalRenderMode(mode: Int): Int

    fun startPreview(): Int

    fun stopPreview(): Int

    /**作用于全局*/
    fun setVideoEncoderConfiguration(config: VideoEncoderConfiguration): Int

    /**作用于全局*/
    fun enableVideo(): Int
    fun enableAudio(): Int
    fun disableVideo(): Int
    fun disableAudio(): Int

    fun enableLocalVideo(enabled: Boolean): Int
    fun enableLocalAudio(enabled: Boolean): Int

    /**作用于全局*/
    fun switchCamera(): Int

    /**作用于全局*/
    fun setupLocalVideo(local: VideoCanvas): Int
    fun setupRemoteVideo(local: VideoCanvas): Int

    fun setEnableSpeakerphone(enabled: Boolean): Int

    fun isSpeakerphoneEnabled(): Boolean

    /*AudioMixing*/
    fun startAudioMixing(filePath: String, loopback: Boolean, replace: Boolean, cycle: Int): Int

    fun setAudioMixingPosition(pos: Int): Int

    fun pauseAudioMixing(): Int

    fun resumeAudioMixing(): Int

    fun stopAudioMixing(): Int

    fun getAudioMixingDuration(): Int

    fun getAudioMixingCurrentPosition(): Int

    /*AudioEffect*/
    fun setLocalVoiceChanger(voiceManager: RteAudioVoiceChanger): Int

    fun setLocalVoiceReverbPreset(preset: RteAudioReverbPreset): Int

    /*MediaDevice*/
    fun enableInEarMonitoring(enabled: Boolean): Int

    fun enableAudioVolumeIndication(interval: Int, smooth: Int, report_vad: Boolean)

    fun setStatisticsReportListener(channelId: String, listener: RteStatisticsReportListener): Int

    fun getError(code: Int): String

    fun OK(): Int

    fun version(): String

    fun dispose()
}
