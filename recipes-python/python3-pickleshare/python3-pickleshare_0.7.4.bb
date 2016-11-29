SUMMARY = "Tiny 'shelve'-like database with concurrency support"
DESCRIPTION = "PickleShare - a small ‘shelve’ like datastore with concurrency support"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=905c08218089ffebea3a64c82fc4d7d0"

SRC_URI = "https://pypi.python.org/packages/69/fe/dd137d84daa0fd13a709e448138e310d9ea93070620c9db5454e234af525/pickleshare-0.7.4.tar.gz"

SRC_URI[md5sum] = "6a9e5dd8dfc023031f6b7b3f824cab12"
SRC_URI[sha256sum] = "84a9257227dfdd6fe1b4be1319096c20eb85ff1e82c7932f36efccfe1b09737b"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/pickleshare/"
UPSTREAM_CHECK_REGEX = "/pickleshare/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/pickleshare-${PV}"

inherit setuptools3
