from django.shortcuts import render

import json
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
        data_out = []
        data = request.data

        name_check = ["name", "fname", "firstname", "first-name", "first_name", "first_name", "Name", "Fname",
                      "Firstname", "First-name", "First_name", "First_name"]
        surname_check = ["Lname", "lname", "surname", "Surname", "sur-name", "Surname", "sur_name", "Sur_name",
                         "last_name"]
        card_id_check = ["card_id", "cardid", "Card_id", "cardnumber", "card_number", "Cardnumber", "Card_number",
                         "personal_id", "Personal_id", "personal-id", "Personal-id", "id_card_number"]
        address_check = ["address", "Address", "local", "Local", ]
        phone_check = ["Phone", "phone", "phonenumber", "phone-number", "phone_number", "Phonenumber", "Phone-number",
                       "Phone_number", "tel", "Tel"]
        gender_check = ["gender", "Gender", "Sex", "sex"]
        gender_m_type_check = ["M", "Male", "male", "man", "Man"]
        gender_f_type_check = ["FM", "F", "Female", "FeMale", "female", "women", "Women"]
        email = ["email", "Email"]

        for company in data:
            defineformat = {}
            for detail in data[company][0]:
                if str(detail) in name_check:
                    defineformat.update({"name": data[company][0][detail]})

                elif str(detail) in surname_check:
                    defineformat.update({"surname": data[company][0][detail]})

                elif str(detail) in card_id_check:
                    defineformat.update({"personal_id": data[company][0][detail]})

                elif str(detail) in address_check:
                    defineformat.update({"address": data[company][0][detail]})

                elif str(detail) in phone_check:
                    defineformat.update({"Phone": data[company][0][detail]})

                elif str(detail) in gender_check:
                    if data[company][0][detail] in gender_m_type_check:
                        defineformat.update({"gender": "male"})
                    if data[company][0][detail] in gender_f_type_check:
                        defineformat.update({"gender": "female"})

                elif str(detail) in email:
                    defineformat.update({"email": data[company][0][detail]})

            data_out.append(defineformat)

            to_mek = match_percent(data_out)
            print("to_mek", to_mek)
        return Response(data_out, status=status.HTTP_200_OK)
    return Response(status.HTTP_400_BAD_REQUEST)


def match_percent(payload):
    """Send data to get format"""
    url = "http://192.168.80.1:8400/to-percent/"  # ลิงค์นี้ใส่ url เมฆ
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    print("Is on going")
    res = requests.post(url, json=payload, headers=headers)
    return res.json()

