#!/usr/bin/env python
import py_eureka_client.eureka_client as eureka_client
import os
import sys


def main():
    your_rest_server_port = 8000
    eureka_client.init_registry_client(eureka_server="http://172.27.0.6:8761/eureka/",
                                       app_name="PERSON_SERVICE",
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
