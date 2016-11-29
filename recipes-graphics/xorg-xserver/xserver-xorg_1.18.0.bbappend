FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += "libepoxy"

PACKAGECONFIG_append = "dri dri3 xshmfence glx"

EXTRA_OECONF += "--enable-glamor"
