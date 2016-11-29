SUMMARY = "Extensions to the standard Python datetime module"
DESCRIPTION = "The dateutil module provides powerful extensions to the datetime module available in the Python standard library."
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51430b33c900f45f999c459ee29ca493"

SRC_URI = "https://pypi.python.org/packages/51/fc/39a3fbde6864942e8bb24c93663734b74e281b984d1b8c4f95d64b0c21f6/python-dateutil-2.6.0.tar.gz"

SRC_URI[md5sum] = "6e38f91e8c94c15a79ce22768dfeca87"
SRC_URI[sha256sum] = "62a2f8df3d66f878373fd0072eacf4ee52194ba302e00082828e0d263b0418d2"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/dateutil/"
UPSTREAM_CHECK_REGEX = "/dateutil/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/python-dateutil-${PV}"

inherit setuptools3
