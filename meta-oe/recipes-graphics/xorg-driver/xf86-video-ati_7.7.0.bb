require recipes-graphics/xorg-driver/xorg-driver-video.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=aabff1606551f9461ccf567739af63dc"

SUMMARY = "X.Org X server -- ATI Radeon video driver"

DESCRIPTION = "Open-source X.org graphics driver for ATI Radeon graphics"

DEPENDS += "virtual/libx11 libxvmc drm xf86driproto glproto \
            virtual/libgl xineramaproto libpciaccess"

COMPATIBLE_HOST = '(i.86|x86_64).*-linux'

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-ati"
SRCREV = "38797a33117222dadbc89e5f21ed8cd5deef9bea"
S = "${WORKDIR}/git"

EXTRA_OECONF_qt5022-open += "--enable-glamor"
EXTRA_OECONF += "--disable-glamor"

RDEPENDS_${PN} += "xserver-xorg-module-exa xserver-xorg-extension-glx"
#Glamor running dependency
RDEPENDS_${PN}_append_qt5022-open = " libegl"
RRECOMMENDS_${PN} += "linux-firmware-radeon"
