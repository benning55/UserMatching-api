#!/usr/bin/env python
import os
import sys
from py_eureka_client import eureka_client


def main():
    your_rest_server_port = 8300
    eureka_client.init_registry_client(eureka_server="http://172.30.0.3:8761/eureka/",
                                       app_name="DATA_FORMAT",
                                       instance_port=your_rest_server_port)
    os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'app.settings')
    try:
        from django.core.management import execute_from_command_line
    except ImportError as exc:
        raise ImportError(
            "Couldn't import Django. Are you sure it's installed and "
            "available on your PYTHONPATH environment variable? Did you "
            "forget to activate a virtual environment?"
        ) from exc
    execute_from_command_line(sys.argv)


if __name__ == '__main__':
    main()