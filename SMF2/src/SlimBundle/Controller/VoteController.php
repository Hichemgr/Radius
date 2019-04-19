<?php

namespace SlimBundle\Controller;


use SlimBundle\Entity\Reclamation;
use SlimBundle\Entity\Vote;
use SlimBundle\Form\VoteType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;

class VoteController extends Controller
{
    public function searchAjaxAction($title)
{
    $em = $this->getDoctrine()->getManager();
    $article = $em->getRepository("SlimBundle:Vote")->FindByLetters($title);
    return $this->render("@Slim/Back/Recherche.html.twig", array('Vote' => $article,));
    $normalizer = new ObjectNormalizer();
    $normalizer->setCircularReferenceLimit(2);
    $normalizer->setCircularReferenceHandler(function ($article) {
        return $article->getId();
    });
    $s = new Serializer(array($normalizer));
    $articles = $s->normalize($article,'json');
    $response = new JsonResponse();
    return $response->setData(array('articles'=>$articles));
}

    public function AfficherVoteAction(Request $request)
    {$moy=0;$moyz=0;$moypv=0;$m=0;$mo=0;
        $proj = $this->getDoctrine()->getRepository(Vote::class)->findAll();
        $em= $this->getDoctrine()->getManager();

        $Vote = $this->get('knp_paginator')
            ->paginate($proj, $request->query->get('page', 1), 4);
        $active=$em->getRepository("SlimBundle:Vote")->countnote();
     $act=$em->getRepository("SlimBundle:Vote")->countnoteZahra();
        $acti=$em->getRepository("SlimBundle:Vote")->countnotePlanteVerte();
        $ac=$em->getRepository("SlimBundle:Vote")->countnotehibiscus();
        $aa=$em->getRepository("SlimBundle:Vote")->countnotemarguerite();
        foreach ($active as $a)
            $moy=$moy+$a['Moyenne'];
        foreach ($act as $a)
            $moyz=$moyz+$a['Moyenne'];
        foreach ($acti as $a)
            $moypv=$moypv+$a['Moyenne'];
        foreach ($ac as $a)
            $mo=$mo+$a['Moyenne'];
        foreach ($aa as $a)
            $m=$m+$a['Moyenne'];
        return $this->render("@Slim/Back/AfficherVote.html.twig", array('V'=>$Vote,'Vote'=>$proj,'moyenne'=>$moy,'moyennez'=>$moyz,'moyennepv'=>$moypv,'moyenneh'=>$mo,'moyennem'=>$m));
    }
    public function SupprimerVoteAction($idvote)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Vote::class)->find($idvote);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("AfficherVote");
    }

    public function ModifierVoteAction($idvote,Request $request){
        $cars=$this->getDoctrine()->getRepository(Vote::class)->find($idvote);
        $form=$this->createForm(VoteType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("AfficherVote");
        }
        return $this->render("@Slim/Back/ModifierVote.html.twig",array("form_modifiervote"=>$form->createView()));
    }
    public function ajouterVoteAction(Request $request)
    {
        $vote = new Vote();

        $form = $this->createForm(VoteType::class, $vote);
        $form->handleRequest($request);
        $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
        $idd= $this->getUser()->getId() ;
        $vote->setIdutilisateur($idd);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($vote);
            $em->flush();
            return $this->redirectToRoute("ajouterVote");
        }

        return $this->render("@Slim/Front/AjouterVote.html.twig",
            array('Vote_form' => $form->createView()));
    }

}
