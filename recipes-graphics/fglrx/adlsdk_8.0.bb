SUMMARY = "AMD Display Library Util"
DESCRIPTION = "AMD Display Library Util"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://../ADL_SDK.html;md5=f746875ee8dcfb3b3222f4b62735cbed"

RDEPENDS_adlutil += "xf86-video-fglrx"

SRC_URI = "http://developer.amd.com/tools-and-sdks/graphics-development/display-library-adl-sdk/ADL_SDK8.zip"
SRC_URI[md5sum] = "f3022bf9101fd9d4b8fbb92095b7d029"
SRC_URI[sha256sum] = "a3db98b44099d0747e45b64a250b818eb6a46ee7ddf0addc9335b2826809db83"

S = "${WORKDIR}/adlutil"

export CXX = "${BUILD_CXX}"
do_compile(){
	$CXX main.c  -DLINUX -fpermissive -ldl -o adlutil
}

do_install(){
	install -d -m 0755 ${D}${includedir}
	cp ../include/*.h ${D}${includedir}
	install -d -m 0755 ${D}${bindir}
	install -m 0755 ${S}/adlutil ${D}${bindir}
}
