import urllib.request
import json

from rest_framework import status
from rest_framework.decorators import api_view, permission_classes
from rest_framework.permissions import AllowAny
from rest_framework.response import Response


@api_view(['GET', ])
@permission_classes([AllowAny, ])
def chesse(request):
    with urllib.request.urlopen("http://localhost:8200/companya/") as url:
        data = json.loads(url.read().decode())
        print(data)
        context = {
            "Bening": "benning",
            "muse": "Muse"
        }
    Response(context, status.HTTP_200_OK)

# Create your tests here.
