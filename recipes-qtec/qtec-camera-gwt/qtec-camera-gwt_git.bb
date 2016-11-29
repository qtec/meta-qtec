DESCRIPTION = "Qtec camera GWT web interface"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=83322fe43cb8f2bc1ea88ab553db0efe"
LIC_FILES_CHKSUM += "file://jni/LICENSE;md5=a14fe441b6663e8969e960a52006e395"
SECTION = "qtec"
PE = "1"

DEPENDS += "v4l-utils gstreamer1.0-plugins-good gstreamer1.0-plugins-qtec-core gstreamer1.0-plugins-base openjdk-8-native"

RDEPENDS_${PN} += "java2-runtime coreutils libv4l procps gstreamer1.0-plugins-qtec-core-meta gstreamer1.0-plugins-good-video4linux2 gstreamer1.0-plugins-good-videocrop gstreamer1.0-plugins-base-videoconvert bash gstreamer1.0-plugins-bad-pnm gstreamer1.0-plugins-good-multifile"

RRECOMMENDS_${PN} += "openjre-8"

SRC_URI = "\
	git://github.com/qtec/GWT_Camera.git;name=base \
	git://github.com/qtec/GWT_Camera_jni.git;name=jni;destsuffix=git/jni \
	file://qtec-camera-gwt \
	"
SRCREV_base = "608476a8a53b7eecbb78e962306a21c234188435"
SRCREV_jni = "029c7acbfdb475eccdd975d2a81d58c868a775e4"

FILES_${PN} += "/usr/share/"

S = "${WORKDIR}/git"

export JAVA_HOME="${STAGING_DIR_NATIVE}/usr/lib/jvm/openjdk-8-native"

do_compile() {
	cd jni
	oe_runmake libV4L2CamInterface.so
}

do_install() {
    install -d ${D}/usr/share/gwt_camera/
    install -m 755 runner.sh ${D}/usr/share/gwt_camera/
    install -m 644 runner.jar ${D}/usr/share/gwt_camera/
    install -m 644 ROOT.war ${D}/usr/share/gwt_camera/
    install -m 644 jni/libV4L2CamInterface.so ${D}/usr/share/gwt_camera/
    install -d ${D}/etc/init.d
    install -m 755 ${WORKDIR}/qtec-camera-gwt ${D}/etc/init.d
}

inherit update-rc.d

INITSCRIPT_NAME = "qtec-camera-gwt"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."

INSANE_SKIP_${PN} = "libdir"
