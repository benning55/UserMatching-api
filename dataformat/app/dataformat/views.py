from django.shortcuts import render


import requests
from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view, permission_classes
from rest_framework.permissions import AllowAny


@api_view(['POST', ])
@permission_classes([AllowAny, ])
def format_data(request):
    """ Make data to the same format """
    if request.method == 'POST':
        data = {
            "Hello": "Sun",
            "And": "Benning"
        }
        return Response(data, status=status.HTTP_200_OK)
    return Response(status.HTTP_400_BAD_REQUEST)
