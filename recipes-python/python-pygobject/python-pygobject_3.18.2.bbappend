FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://undefined.patch"
EXTRA_OECONF = "--with-python=python2.7"
DEPENDS +=  "cairo python-pycairo"
