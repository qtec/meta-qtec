SUMMARY = "AMD OpenGL ES Library"
DESCRIPTION = "AMD OpenGL ES Library"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://README.txt;md5=cce136f4a63982a7881c7727864712ae"
INSANE_SKIP_${PN} = "ldflags already-stripped"

PROVIDES = "virtual/libgles1 virtual/libgles2 virtual/egl"
DEPENDS = "mesa"

SRC_URI = "http://amd-dev.wpengine.netdna-cdn.com/wordpress/media/2012/10/gles_sdk.zip"

SRC_URI[md5sum] = "06bc7fae4a38d0bbfe3317499ffe2b01"
SRC_URI[sha256sum] = "e39d3b8479a6b0e4d3a78f8d78c5ee6d6dbcb46329c7c9dfba6dd55ccc204a0f"

S = "${WORKDIR}/gles_sdk"

do_compile(){
}

do_install(){
	install -d -m 0755		${D}${libdir}
	install -m 0755  ${S}/${@bb.utils.contains("TARGET_ARCH", "x86_64", "x86-64", "x86", d)}/libEGL.so ${D}${libdir}/libEGL.so.1.0.0
	ln -sf libEGL.so.1.0.0 ${D}${libdir}/libEGL.so.1
	ln -sf libEGL.so.1.0.0 ${D}${libdir}/libEGL.so
	install -m 0755  ${S}/${@bb.utils.contains("TARGET_ARCH", "x86_64", "x86-64", "x86", d)}/libGLESv2.so ${D}${libdir}/libGLESv2.so.2.0.0
	ln -sf libGLESv2.so.2.0.0 ${D}${libdir}/libGLESv2.so.2
	ln -sf libGLESv2.so.2.0.0 ${D}${libdir}/libGLESv2.so
}
