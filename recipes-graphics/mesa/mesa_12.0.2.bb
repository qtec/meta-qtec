require recipes-graphics/mesa/${BPN}.inc

DEPENDS += "nettle python-mako-native libva libomxil"

LIC_FILES_CHKSUM = "file://docs/license.html;md5=899fbe7e42d494c7c8c159c7001693d5"

SRC_URI = "git://anongit.freedesktop.org/mesa/mesa;branch=master"
SRCREV = "4ea90682abb2ea9d605987de4317805dcd5f03be"
S = "${WORKDIR}/git/"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}

PACKAGES += "libmesaopencl libmesaopencl-dev libomx-mesa libomx-mesa-dev"

#Qtec configuration:
DEPENDS += "openssl libclc llvm-common libva"
MESA_LLVM_RELEASE = "3.9.0"
PACKAGECONFIG += "gbm egl gles dri r600 gallium-llvm x11 gallium dri3"
EXTRA_OECONF += "--enable-opencl --enable-opencl-icd --enable-va --enable-omx"
FILES_libmesaopencl-dev = "${libdir}/libMesaOpenCL.so ${libdir}/libMesaOpenCL.la"
FILES_libmesaopencl = "${libdir}/libMesaOpenCL.so.* ${sysconfdir}"
FILES_libomx-mesa = "${libdir}/bellagio/libomx_mesa.so"
FILES_libomx-mesa-dev = "${libdir}/bellagio/libomx_mesa.la"
FILES_${PN} = ""
